приложение для управлением списком сотрудников, используя Spring, Hibernate, встроенная БД с 3-5 связанными таблицами.

Приложение должно состоять из трех элементов

* форма добавление сотрудника, должна быть представлять собой страницу с формой ввода информации о сотруднике, включая ФИО, должность, отдел
* список сотрудников, должен представлять собой список сотрудников в JSON формате
* информация о сотруднике, должна предоставлять данные о сотруднике в JSON формате
* страница авторизации для администрирования (после развёртывания приложения у нас должна быть возможность войти, имея авторизационные данные)

Приложение должно быть реализовано используя Spring Web MVC и собрано с использованием Maven в формате war для размещения в контейнере сервлетов Tomcat.


# server-port: 8082


swagger2 doc:
http://localhost:8082/swagger-ui.html#

curl -X DELETE http://localhost:8082/delete/1