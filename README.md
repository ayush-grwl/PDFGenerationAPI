# PDFGenerationAPI
API to generate dynamic PDF

Steps to run the API:

  1) Download the folder from github and open the folder in eclipse or any other java supporting IDE(Preffered is Eclipse)
  2) Run the application as 'Spring Boot App'
  3) Open the postman and in GET Mapping enter the url 'localhost:8080/generatePDF'
  4) In body tab in postman select raw and type as json and enter the data in correct format:
      {
        "seller": "",
        "sellerGstin": "",
        "sellerAddress": "",
        "buyer": "",
        "buyerGstin": "",
        "buyerAddress": "",
        "items": [
          {
            "name": "",
            "quantity": "",
            "rate": ,
            "amount": 
          }
        ]
    }
    5) After entering the data click on send and if the input is correct then the PDF will be downloaded in downloads folder
    
If you want to run the test case then run as 'JUnit Test'
