# marketing


********************************

1) Based on the doc - PI.EXCHANGE_Software Engineer Case Study_20201021.pdf, 
   the subject value in the email template is "A new product is being launched soon...". 
   However the value in the sample email template is "{{FIRST_NAME}}, a new product is being launched soon...". 
   I assume that the doc is correct. Because the value in the sampe output_email.json is "A new product is being launched soon...". 

2) In the most case, there should be more than one customer in customers.csv. So I merge all output content into one file. 
   Please be aware that there will be one curly-braces around the json content. 

[
  {
    "from": "The Marketing Team<marketing@example.com",
    "to": "john.smith@example.com",
    "subject": "A new product is being launched soon...",
    "mimeType": "text/plain",
    "body": "Hi Mr John Smith,\nToday, 17 Jan 2021 , we would like to tell you that... Sincerely,\nThe Marketing Team"
  }
]

or 

[
  {
    "from": "The Marketing Team<marketing@example.com",
    "to": "john.smith@example.com",
    "subject": "A new product is being launched soon...",
    "mimeType": "text/plain",
    "body": "Hi Mr John Smith,\nToday, 17 Jan 2021 , we would like to tell you that... Sincerely,\nThe Marketing Team"
  },
  {
    "from": "The Marketing Team<marketing@example.com",
    "to": "michelle.smith@example.com",
    "subject": "A new product is being launched soon...",
    "mimeType": "text/plain",
    "body": "Hi Mrs Michelle Smith,\nToday, 17 Jan 2021 , we would like to tell you that... Sincerely,\nThe Marketing Team"
  }
]

not like sample output file - output_email.json. 

  {
    "from": "The Marketing Team<marketing@example.com",
    "to": "john.smith@example.com",
    "subject": "A new product is being launched soon...",
    "mimeType": "text/plain",
    "body": "Hi Mr John Smith,\nToday, 17 Jan 2021 , we would like to tell you that... Sincerely,\nThe Marketing Team"
  }

********************************