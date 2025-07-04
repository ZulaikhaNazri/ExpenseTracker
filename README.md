

`git clone https://github.com/ZulaikhaNazri/ExpenseTracker.git`


setup mysql database and update user detail dekat application.properties


mvn clean install


run `java -jar target/expenses-tracker.jar`. @ guna ide


Open your web browser and navigate to `http://localhost:9090`.


RESTAPI kena ada basic auth

contoh api request untuk POSTMAN
```bash
curl --location 'http://localhost:9090/api/expenses/add' \
--header 'Content-Type: application/json' \
--header 'Authorization: ••••••' \
--data '{
    "clientId" : 9,
    "category" : "asdfasdf",
    "amount" : 2,
    "dateTime" : "2025-07-04T15:24",
    "description" : "abc"
}'
```
