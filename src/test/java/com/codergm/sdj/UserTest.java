package com.codergm.sdj;

import com.codergm.sdj.entity.User;
import com.codergm.sdj.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test_query_by_example1() {
        User user = User.builder().lastname("Smith").level(2).build();
        Example<User> example = Example.of(user); // user object is a prob
        List<User> users = userRepository.findAll(example);
        users.forEach(System.out::println);
        assertEquals(2, users.size());
    }

    @Test
    void test_query_by_example2() {
        User user = User.builder().lastname("Smith").build();
        Example<User> example = Example.of(user); // user object is a prob
        List<User> users = userRepository.findAll(example);
        System.out.println(users.size());
        assertEquals(0, users.size());
    }

    @Test
    void test_query_by_example3() {
        User user = User.builder().lastname("Smith").build();
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("level");
        Example<User> example = Example.of(user, matcher); // user object is a prob
        List<User> users = userRepository.findAll(example);
        System.out.println(users.size());
        assertEquals(3, users.size());
    }

    @Test
    void test_query_by_example4() {
        User user = User.builder().firstname("s").build();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnorePaths("level")
                .withIgnoreCase();

        Example<User> example = Example.of(user, matcher);

        List<User> users = userRepository.findAll(example);
        assertEquals(2, users.size());
    }

    @Test
    void test_question1() {
        User user = User.builder().firstname("s").email("@else.com").build();
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<User> example = Example.of(user, matcher);
        List<User> users = userRepository.findAll(example);
        assertEquals(2, users.size());
    }

    @Test
    void test_query_by_example5() {
        User user = User.builder().firstname("s").email("@Else.com").build();
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("level")
                .withMatcher("firstname", match -> match.startsWith())
                .withMatcher("email", match -> match.endsWith())
                .withIgnoreCase();
        Example<User> example = Example.of(user, matcher);
        List<User> users = userRepository.findAll(example);
        System.out.println(users.size());
        assertEquals(1, users.size());
    }


    //@BeforeAll
    public void populateDb() {
        User user1 = new User("gillamy01", "Amy", "Gill", "amy@somewhrelse.com", 1);
        User user2 = new User("smithjohn02", "John", "Smith", "john@somewhr.com", 2);
        User user3 = new User("lawsonmike03", "Mike", "Lawson", "mike@else.com", 3);
        User user4 = new User("lambian03", "Ian", "Lamb", "ian@somewhr.com", 3);
        User user5 = new User("bailektora02", "Tora", "Bailek", "tora@somewhr.com", 2);
        User user6 = new User("smithsadie01", "Sadie", "Smith", "sadie@somewhrelse.com", 1);
        User user7 = new User("ambrizsharon01", "Sharon", "Ambriz", "sharon@else.com", 1);
        User user8 = new User("singhrahul02", "Rahul", "Singh", "rahul@somewhr.com", 2);
        User user9 = new User("smithjoe02", "Joe", "Smith", "joe@else.com", 2);
        User user10 = new User("johnsonleo03", "Leo", "Johnson", "leo@somewhr.com", 3);
        User user11 = new User("leebrett04", "Brett", "Lee", "brett@else.com", 4);

        userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11));
    }

    //Query By Example(QBE) Limitations:
    //Only supports start/contains/ends/regex matching for strings and exact matching for other property types
    //No support for nested/grouped property constraints, such as "firstname = ?0 or (firstname = ?1 and lastname = ?2)
}
