create repl, something like a cli "api"

must organize the project in packages:

view;

service;

dao;

# database;

3 filesj

must create a interface called DatabaseTableI

must create a concrete class DatabaseTable 
( can use list or map, but must use id to optmized operations)

the operations findById, update and delete, must throw  a EntityNotFoundException,
children of DatabaseException when necessary

this class must have a int attribute that must be increase and use as id of new entities

furthermore, you must create a class Database, that will indeed represent the database,
owning DatabaseTables for all entities of the system

this class must use the design pattern singleton

Database deve ter como atributo inteiro um mapa cuja chave é o nome de uma classe e o
valor é uma DatabaseTable deste tipo. Por exemplo, para a chave Product.class, o valor
associado é do tipo DatabaseTable<Product>



exception;


# entity;

must create a Entity class with a id and getters and setters

create something that generate ids, if possivle uuids

equals must be overwritted to check only if ids are the same

every entity create for the system must be Entity children

