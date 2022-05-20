package edu_school21_chat.repositories;

import edu_school21_chat.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll(int page, int size);
}
