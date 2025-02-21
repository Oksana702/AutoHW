Feature: Login Functionality

  Scenario: Успешный вход в систему с валидными данными
    Given пользователь находится на странице входа
    When он вводит "mail@mail.by" в поле Email
    And вводит "qwerty12" в поле Password
    And нажимает на кнопку Sign in
    Then он должен успешно войти в систему

  Scenario: Попытка входа только с паролем
    Given пользователь находится на странице входа
    When он вводит "" в поле Email
    And вводит "qwerty12" в поле Password
    And нажимает на кнопку Sign in
    Then он должен увидеть сообщение об ошибке "Email is required"

  Scenario: Попытка входа только с Email
    Given пользователь находится на странице входа
    When он вводит "mail@mail.by" в поле Email
    And вводит "" в поле Password
    And нажимает на кнопку Sign in
    Then он должен увидеть сообщение об ошибке "Password is required"