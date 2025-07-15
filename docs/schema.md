

# Database Schema - Job Application Tracker

## Table: job_application

| Column           | Type        | Description                    |
|------------------|-------------|--------------------------------|
| id               | BIGINT      | Primary key                    |
| company_name     | VARCHAR(100)| Company name                   |
| position         | VARCHAR     | Job position                   |
| job_link         | VARCHAR(255)| Job advertisement link         |
| application_date | DATE        | Date of application            |
| status           | VARCHAR     | Current status (e.g. Interview)|
| notes            | CLOB        | Additional notes               |
| response_date    | DATE        | Date of company response       |
| interview_date   | DATE        | Date of interview              |
| result           | VARCHAR     | Result of application          |
| source           | VARCHAR     | Application source (LinkedIn)  |