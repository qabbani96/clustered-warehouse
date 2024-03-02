# clustered-warehouse #

This Service just for create deal and get list of deals 

## Pre-requirment ##

- JDK 17 
- Maven 
- MongoDB

## Run using docker ##

- Open the project using intellija 
- Go to the terminal and run "docker-compose up"
- if you have your own Mongo you can use the docker file "docker build -t cluster-da ."

## Question ##
ClusteredData Warehouse

Suppose you are part of a scrum team developing data warehouse for Bloomberg to analyze FX deals. One of customer stories is to accept deals details from and persist them into DB.

## Request logic as following ##
-Request Fields(Deal Unique Id, From Currency ISO Code "Ordering Currency", To Currency ISO Code, Deal timestamp, Deal Amount in ordering currency).
-Validate row structure.(e.g: Missing fields, Type format..etc. We do not expect you to cover all possible cases but we'll look to how you'll implement validations)
-System should not import same request twice.
-No rollback allowed, what every rows imported should be saved in DB.
### please check the Cluster-Data.postman to see the postman collection ###


