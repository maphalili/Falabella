Feature: Agregar producto al carrito de compras


Scenario: Agregar un producto consultado en la pagina de falabella al carrito de compras
Given busco falabella
When busco un producto
Then agrego el producto al carrito de compras
