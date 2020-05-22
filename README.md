Warehouse Investory System

Please compile this project on spring tool suite or compile as a spring boot application by using your own way.

After compile it successfully, please browse'localhost:8080' on browser There are 5 pages for different function:

1.Homepage(index.html) -link to other pages -show the productlist

2.Update product information page(importproductcsv.html) -put your csv file into "HoganWIS/src/main/resources" and save it with name"product.csv"

-After put the csv file, click the button to upload the csv to database

-Please save the csv with the format 'name,code,weight'

-In  "HoganWIS/src/main/resources", I have a sample for reference

3.Update location information page(importlocationcsv.html)

-put your csv file into "HoganWIS/src/main/resources" and save it with name"locatoin.csv"

-After put the csv file, click the button to upload the csv to database

-Please save the csv with the format 'location,code,quantities'

-In  "HoganWIS/src/main/resources", I have a sample for reference

4.Show Iventory page(showproduct.html)

-here will show all the inventory

-input the product code into the searching box will filter the inventory according to the product code

5.Transfer page(transfer.html)

-able to transfer inventory from one location to another location

-input all the information to the corresponding box

-click transfer button to to the action


Daily log book 
15/5-19/5 
I am sorry that as the examination period, I don't have time work on the challenge yet betwwen these days.

20/5 
I findout what the componets of making a java web app first, so I learnt how to use spring(and created a maven project), git repository(and made a git repository), mysql and mysql workbench. After that, I start run a local database on my computer first, then learnt modify the application.properties to connect the database with my project.

21/5 After learnt the basic concept to build a java web app (database->repository->service->controller->html), I decided how many components, how many enetities and wts element of these enetities of my project. So I tried to develop all the componets and keep debug and keep learning how to build by watching youtube and google.

In the process, I tried to use sumbit file type on html to do the csv upload action, however, I spend me a lot of time with no result, so I tried the another way, upload the csv file on the project path first instead of upload on html.

22/5 
I tried my best to make the ui more beauty by modify some css and test if any bugs here.

Final, I created a aws online database and change my projects path to it and test all the function again.

As the time limit, although all the functions are work and fullfilled, it is not perfectedly showed, but I am already try my best to learn it and build it.
