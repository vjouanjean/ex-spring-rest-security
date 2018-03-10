curl -i --header "Accept:application/json" -X GET http://localhost:8080/action
401

curl -i -X POST -d username=user -d password=password http://localhost:8080/login
200

curl -i --header "Accept:application/json" -X GET http://localhost:8080/action -b "JSESSIONID=<ID>; Path=/; HttpOnly"
200