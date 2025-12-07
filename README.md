## HMCTS DEVELOPER TEST BACKEND

Allows you to create a new task via POST localhost:8080/task/create

```http Request Object
POST /task/create
Content-Type: application/json
{
  "title": "String",
  "description": "String",
  "status": "String",
  "dueTateTime": "DateTime" format:"2025-12-07T10:30:00"
}

Response Object
{
  "id": "String",
  "title": "String",
  "description": "String",
  "status": "String",
  "dueTateTime": "DateTime" format:"2025-12-07T10:30:00"
}
