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

curl -X PUT -H "Content-Type: application/json" -d '{"id":2,"firstname":"UPD-user-fn","lastname":"UPD-user-ln","email":"UPD-email2@email.89999","department_id":3,"position_id":3,"pass":"ASDEWQ6667"}' http://localhost:8082/upd/2

curl -H "Content-Type: application/json" -X POST -d '{"firstname":"NEW-user","lastname":"NEW-user-ln","email":"NEW-email2@email.89999","department_id":1,"position_id":3,"pass":"NEWPass7763"}' http://localhost:8082/new/employee

#with authentication:

curl --user user:<secret в момент деплоя> -H "Content-Type: application/json" -X POST -d '{"firstname":"NEW-user","lastname":"NEW-user-ln","email":"NEW-email2@email.89999","department_id":1,"position_id":3,"pass":"NEWPass7763"}' http://localhost:8082//new/employee


