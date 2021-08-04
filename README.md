# ChargePoint-Assignment
Fleet Scheduling Question.

# Problem Statement
Imagine that you are responsible for a fleet of electric mail trucks. You need to get all your trucks recharged overnight so they are ready for the next day. Please write code to come up with a schedule for charging your trucks. 

You have:

1.	Some number of trucks, each with a unique ID, battery capacity (in kilowatt hours), and current level of charge
2.	Some number of chargers, each with a unique ID and charging rate (in kilowatts)
3.	A specified amount of time (an integer number of hours)

Your goal is to get as many trucks as possible charged to full capacity in the specified amount of time. 

You should make the following assumptions:

1.	Each charger can charge one truck at a time
2.	Once a truck starts charging, it must continue until it is fully charged
3.	Once a truck is done charging, it takes zero seconds before the next truck can start charging on the same charger

Your task is to write code that prints a schedule indicating which trucks should be charged on each charger. 
For example, if your code prints:

1: 1, 3
2: 4
That means that trucks 1 and 3 should be charged on charger 1 and truck 4 should be charged on charger 2. Truck 2 will not be charged by the end of the time period.
Approach taken
The solution for the above mentioned problem can be achieved in more than one approach and all these approach will give you the right results but implementing the best scheduling algorithm based on time is the approach we are looking to implement here. The code was tested with following algorithms 1. First Come First Serve, 2. Shortest Job First, 3. Shortest remaining time first and based on the best time results the right algorithm has been chosen for implementation. The algorithm we choose for this implementation is SHORTEST REMAINING TIME FIRST algorithm.

## Getting Started

### Installing
```
Please unzip the folders attached and use any tools of your choice to import the code.
```

# Running the build and tests
Demo-able unit test to verify functionality & test the integrity of the solution provided.

#### Unit Test
````
org.chargepoint.helper.SchedulingHelperTest.java
org.chargepoint.controller.FleetServiceTest.java
````

#### Build Artifact
````
mvn clean install
````

#### Deployment
````
java -jar target\ChargePointAssesment-1.0-SNAPSHOT-jar-with-dependencies.jar OR run the Application.java
````

## Libraries Used
Maven is configured to fetch these libraries.
````
junit-4.12.jar for JUnit test cases.
Powermock-2.0.4.jar for Junit test cases.
````

## Built With
*	Java
*	Junit
*	Maven

Note - Output folder is kept to peek into the results. When you run the application these files will get generated as well.

