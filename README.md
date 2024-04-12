Description of my first CRUD Application "TestCRUD"
To run application firstly we need to start the db, after put our credentials to it in application.properties file


Description of API
Application is running on port 8080, so in our address bar we write **http://localhost:8080**
if we eant to work with products, we should write "/products"
- GET "products" - will return all the products
- GET "products/{id}" - will return a specified product
- Put "products/{id}" - will update a specified product
- POST "products" - will save a product
- DELETE "products/{id}" - will delete a product

The same situation is with orders, we simply need to change our word products on orders
