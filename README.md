## HMCTS DEVELOPER TEST BACKEND

Allows you to create a new task

POST /task/create | Runs on Localhost:8080 by default

Content-Type: application/json

**Request Body:**

```json
{
  "title": "String",
  "description": "String",
  "status": "String",
  "dueTateTime": "2025-12-07T10:30:00"
}
```

**Response Body:**
```json
{
  "id": "String",
  "title": "String",
  "description": "String",
  "status": "String",
  "dueTateTime": "2025-12-07T10:30:00"
}
```
