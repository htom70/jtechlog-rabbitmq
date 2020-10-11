RabbitMQ bevezető
=================

Ez a program a JTechLog (<http://jtechlog.hu>) blog _RabbitMQ használata Spring Boottal_ posztjához készült példaprogram.
A letöltést követően Mavennel, az `mvn spring-boot:run` paranccsal buildelhető és
futtatható. Fejlesztőeszközben a `EmployeesApplication` osztály futtatásával indítható.

Futtatásához futó RabbitMQ szükséges, mely a következő paranccsal indítható:

```shell
docker run -d --hostname my-rabbit --name my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

A következő http kérésre reagál:

```shell
http http://localhost:8080/api/employees name="John Doe"
```

Ez a következő JSON-t postolja el a megadott URL-re:

```json
{
    "name": "John Doe"
}
```


viczian.istvan a gmail-en
