**Wallet-Service**

Необходимо создать сервис, который управляет кредитными/дебетовыми транзакциями
от имени игроков.

**Описание**

Денежный счет содержит текущий баланс игрока. Баланс можно изменить,
зарегистрировав транзакции на счете, либо дебетовые транзакции (удаление средств),
либо кредитные транзакции (добавление средств).
Создайте реализацию,
которая соответствует описанным ниже требованиям и ограничениям.

**Требования**

* данные хранятся в памяти приложений
* приложение должно быть консольным (никаих спрингов, взаимодействий с БД и тд,
только java-core и collections)
* регистрация игрока
* авторизация игрока
* Текущий баланс игрока
* Дебет/снятие средств для каждого игрока Дебетовая транзакция будет успешной
только в том случае, если на счету достаточно средств (баланс - сумма дебета >= 0).
 - Вызывающая сторона предоставит идентификатор транзакции, который должен быть
 уникальным для всех транзакций. Если идентификатор транзакции не уникален,
 операция должна завершиться ошибкой.
* Кредит на игрока. Вызывающая сторона предоставит идентификатор транзакции,
который должен быть уникальным для всех транзакций. Если идентификатор транзакции
не уникален, операция должна завершиться ошибкой.
* Просмотр истории пополнения/снятия средств игроком
* Аудит действий игрока (авторизация, завершение работы, пополнения, снятия и тд)

**Нефункциональные требования**

Unit-тестирование
