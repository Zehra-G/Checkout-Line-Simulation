# Simulating Shoppers Picking a Check-out Line Using Queue Implementation
## Abstract
In this project, I designed a simulation of a multi-station checkout situation using queue implementation. Three different approaches to choose a queue were implemented, and their effectiveness was investigated. To do this, I created an abstract Customer class that three different types of customer classes (RandomCustomer, PickyCustomer, and Pick2Customer) inherited from. Random customer class objects choose the checkout agent that they will join randomly, PickyCustomer chooses the checkout agent with the shortest line (smallest number of customers), and the Pick2Customer class objects pick two checkout agents, compare them and join the shortest queue. Besides these abstract Customer classes and the three child classes, I had a CheckoutAgent class that maintained a queue of Customers. In the updateState method of this class, I used the queue methods peek and poll that we implemented in the lab. The Landscape class maintained an ArrayList of checkout agents and a list of customers who were done with the checkout. The LandscapeDisplay class that contained the Graphics code for the Landscape’s agents to be drawn was provided to us. Finally, I had a simulation class for every child class of the Customer: RandomCustomerSimulation, Pick2CustomerSimulation, and PickyCustomerSimulation. In these simulations, I generated 99 customers of the corresponding subclass and visualized how they are added to 5 CheckoutAgents. Finally, I changed the number of customers to calculate the statistics of the simulations, and evaluated the differences between the three approaches to choosing a checkout agent.
# Results
When every customer joining the checkout agents had 1 to 10 items randomly assigned to them, the lines grew over time. This can be seen in Fig.1, Fig.3 and Fig.5 below. When I adjusted the upper limit to 5 so that every customer could have 1 to 5 items to check out, the lines did not grow in the simulation. Although there were small queues forming in checkout agents occasionally, the checkout agents found a balance and were largely available most of the time. This result can be seen for each type of customer (RandomCustomer, PickyCustomer, Pick2Customer) at Fig.2, Fig.4, and Fig.6 below.

 <img width="315" alt="Screen Shot 2022-11-07 at 16 56 26" src="https://user-images.githubusercontent.com/113384943/200423818-33491cf6-a855-47dd-b684-36fe18f5d557.png">

Fig. 1)RandomCustomerSimulation’s checkout agents after 99 customers with 1-10 items

<img width="320" alt="Screen Shot 2022-11-07 at 16 56 52" src="https://user-images.githubusercontent.com/113384943/200423895-900f0dae-e837-47d8-9468-87eb9b917dea.png">


Fig. 2)RandomCustomerSimulation’s checkout agents after 99 customers with 1-5 items


 <img width="321" alt="Screen Shot 2022-11-07 at 16 57 10" src="https://user-images.githubusercontent.com/113384943/200423959-e45a0124-97b5-4a82-a0ea-4c0721be0a3d.png">

Fig. 3)PickyCustomerSimulation’s checkout agents after 99 customers with 1-10 items


<img width="319" alt="Screen Shot 2022-11-07 at 16 57 30" src="https://user-images.githubusercontent.com/113384943/200424006-8882e868-0c0a-429e-8614-a5370b8c97f5.png">

Fig. 4)PickyCustomerSimulation’s checkout agents after 99 customers with 1-5 items

<img width="321" alt="Screen Shot 2022-11-07 at 16 57 49" src="https://user-images.githubusercontent.com/113384943/200424060-6c0ccdd3-52f2-42f7-9627-61ffebbcdda4.png">


Fig. 5)Pick2CustomerSimulation’s checkout agents after 99 customers with 1-10 items

 <img width="326" alt="Screen Shot 2022-11-07 at 16 58 06" src="https://user-images.githubusercontent.com/113384943/200424119-c64b3f42-e0ad-4843-abb6-f64579c9bc47.png">

Fig. 6)Pick2CustomerSimulation’s checkout agents after 99 customers with 1-5 items
 
 After adding a printFinishedCustomerStatistics() method to my Landscape class, I was able to calculate the average and the standard deviation of the time that the customers spent in the line. I ran each of the three simulations with 1000 customers and printed out these statistics in every 100 steps of updating the checkout agents of the landscape. Below in Fig.7, Fig.8, and Fig.9 these results can be seen.
We can see that the average time spent in the line for a picky customer is the highest. This result makes sense because the PickyCustomer examines the lengths of all the lines before choosing one. Then, RandomCustomer is the second highest, however quicker than the PickyCustomer and closer to the fastest customer type, Pick2Customer. These results also make sense because even though Pick2Customer randomly picks two lines instead of one, since it compares the length of the lines and goes to the shorter one it saves time in total. Standard deviation of the time spent between the RandomCustomer was the highest, since it chooses a line randomly and there is a greater variation. Pick2Customer and PickyCustomers’ standard deviation of the time spent in the lines were close to each other however, PickyCustomer’s standard deviation was lower.

<img width="540" alt="Screen Shot 2022-11-07 at 16 59 07" src="https://user-images.githubusercontent.com/113384943/200424283-85752f32-646b-42b5-b2e6-9cb081bd39e7.png">


Fig. 7) The periodic statistics of running RandomCustomerSimulation for 1000 customers with 1-5 items

<img width="554" alt="Screen Shot 2022-11-07 at 16 59 22" src="https://user-images.githubusercontent.com/113384943/200424332-e11ac83f-52aa-4990-9999-2d63383e5755.png">


Fig. 8) The periodic statistics of running PickyCustomerSimulation for 1000 customers with 1-5 items

<img width="552" alt="Screen Shot 2022-11-07 at 16 59 42" src="https://user-images.githubusercontent.com/113384943/200424388-2c0d7461-f87e-4553-b9f8-128269b166ef.png">


Fig. 9) The periodic statistics of running Pick2CustomerSimulation for 1000 customers with 1-5 items

### References & Acknowledgements
Prof. Allen Harper, Colby College

Prof. Max Bender, Colby College
