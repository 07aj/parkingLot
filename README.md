# Parking Lot


## Model
Contians the POJOS to simulate a car

## View
Contains the interaction like CLI and file upload

##Controller 
Contains the core login of the project

##Constants 
Contains the Enum

## Test
Contains Unit test cases to be executed

## bin/

Contains setup file including commands
# Add script to:
# * Install dependencies
# * Build/Compile
# * Run Test Suit to validate
#
# After this is run, bin/parking_lot
# should Just Work.
echo "Clean the target Directoy and Compile the project"
mvn -f ../parkingLot/pom.xml clean compile

echo "Download Dependencies and Run Unit Tests"
mvn -f ../parkingLot/pom.xml install

Contains parking_lot is to ru the created jar from setup

#!/usr/bin/env bash
# Add script to run program here.
# Complete bin/setup so that after it is
# run, bin/parking_lot can be used to launch
# it.

# This variable contains absolute path of this `parking_lot` script
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

# Use DIR variable above to pinpoint your jar/executable/main class
# e.g.
# - if java
#   java -cp $DIR/../target/ParkingLot-1.0-SNAPSHOT.jar com.gojek.Main $1
# - if python
#   python3 $DIR/../main.py $1
# - if ruby
#   ruby $DIR/../main.rb $1
# 
# Important: Above commands is just examples, please modify to suit your requirement as necessary
java -jar $DIR/../parkingLot/target/parkingLot.jar $1

## To Run the cases
Execute `bundle exec rake spec:functional` 
inside functional spec

