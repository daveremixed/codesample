# codesample

## Requirements
Here is a little coding challenge for you. This shouldn't take more then an hour and can really show your skills and abilities.  
You can write it in Python or Java, whatever is best for you!!  Just make it good =)  Don’t worry about Docker if you haven’t used it.
  
1. Using the Donors Choose API (http://api.donorschoose.org/), create an application that does the following:
2. The application should accept 1 search parameter which can be defined at runtime 
     (user can be prompted or user can pass a search query through a command line interface)
3. Results are limited to the following (add an assertion in the code to verify the following three criteria):
4. Five results maximum
5. Results should be limited to California
6. Funding cost should be within $0 -  $2,000
7. Results should be sorted by the following criteria:
     a. Highest Urgency should be shown first
     b. Results should only list the following information for each proposal:
          - Title
          - Short Description
          - ProposalURL
          - Cost To Complete
     c. List the average totals for the following values (aggregated from all five of the listed proposals):
          - Percent Funded
          - Number of Donors
          - Cost To Complete
          - Number of Students
          - Total Price
8. As a bonus, submit the code along with a working Docker image of the application
