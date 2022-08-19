package org.example;


public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceClass();
        User user = userService.getUser("1");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getPhone());
        System.out.println(user.getBirthDate());
    }
}