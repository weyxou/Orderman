Makushova Nurzhibek

Order Management API
Description
This project is an API for managing orders in an online store. The API provides a set of operations for working with orders, 
including creating, reading, updating and deleting (CRUD) orders. 
The project also implements an authentication and authorization system for users with roles.

Main features:
- User registration and authentication: Create new users with assigned roles.
- CRUD operations for order management: create new orders, receive information about orders, update and delete them.
- Role access: Access to certain operations is limited by roles, for example, only administrators can delete orders.

All operations are performed using Postman, which makes it convenient to send API requests and receive responses in various formats, 
including JSON. This makes it possible to test all API functionality and facilitates the development of client applications.

API Operations

1. Authentication and user management
- Registrtion of a new user: allows you to register a new user with his data and roles.

2. Order Management
- Create a new order: Allows you to create a new order specifying the customer, amount and status.
- Getting order information by ID: allows you to get information about a specific order by its ID.
- Order Update: Allows you to update the data of an existing order, for example, to change the status or amount.
- Deleting an order: Deletes an order from the system by the specified ID.
- Getting a list of all orders: Returns information about all orders in the system.

Conclusion
This project implements the main functions for managing orders in an online store. 
The API uses REST principles to create a simple and user-friendly interface for working with orders and users, 
and also implements a basic authentication and authorization system to restrict access to certain operations.
