# user-org-api

## Use Docker be initiate Mysql

docker-compose up -d

## Build project

mvn clean package

## run project

java -jar target/user-org-app-0.0.1-SNAPSHOT.jar

## Endpoints

### Users

- Create User:  POST /api/users
- Get All Users: GET /api/users
- Get User: GET /api/users/{userId}
- Update User: PUT /api/users/{userId}
- Delete User: DELETE /api/users/{userId}

### Organizations

- Create Organization:  POST /api/organizations
- Get All Organization: GET /api/organizations
- Get Organization: GET /api/organizations/{organizationsId}
- Delete Organization: DELETE /api/organizations/{organizationsId}

### User Organization Relation

- Add User to an Organization: POST /api/userorg/{organizationId}/{userId}
- Delete a User from an Organization: PUT /api/userorg/{organizationId}/{userId}
- Read all Users belong to a Organization: GET /api/userorg/org/{organizationId}
- Read all Organizations a User belongs to : GET /api/userorg/user/{userId}