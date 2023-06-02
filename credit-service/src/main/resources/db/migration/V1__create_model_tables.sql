CREATE TABLE IF NOT EXISTS users (
  id uuid PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  income DECIMAL(12,2) NOT NULL,
  birth_date DATE NOT NULL,
  last_work_experience INTEGER NOT NULL,

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS loans (
  id uuid PRIMARY KEY,
  user_id uuid NOT NULL REFERENCES users(id),
  bank_name VARCHAR(256) NOT NULL,
  amount DECIMAL(12,2) NOT NULL,
  interest_rate DECIMAL(5,2) NOT NULL,
  term INTEGER NOT NULL,
  status VARCHAR(20) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS loan_criteria (
  id uuid PRIMARY KEY,
  loan_id uuid NOT NULL REFERENCES loans(id),
  income_level varchar(128) NOT NULL,
  credit_rating varchar(128) NOT NULL,
  person_age INTEGER NOT NULL,
  work_experience INTEGER NOT NULL,
  worthiness varchar(128),

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS transactions (
  id uuid PRIMARY KEY,
  user_id uuid NOT NULL REFERENCES users(id),
  amount DECIMAL(12,2) NOT NULL,
  type VARCHAR(20) NOT NULL,
  date DATE NOT NULL,
  description TEXT,

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS budget_plans (
  id uuid PRIMARY KEY,
  user_id uuid NOT NULL REFERENCES users(id),
  name VARCHAR(100) NOT NULL,
  amount DECIMAL(12,2) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  is_recurring BOOLEAN NOT NULL,

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS financial_reports (
  id uuid PRIMARY KEY,
  user_id uuid NOT NULL REFERENCES users(id),
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  income DECIMAL(12,2) NOT NULL,
  expenses DECIMAL(12,2) NOT NULL,
  loans DECIMAL(12,2) NOT NULL,
  savings DECIMAL(12,2) NOT NULL,
  total_assets DECIMAL(12,2) NOT NULL,
  total_liabilities DECIMAL(12,2) NOT NULL,
  net_worth DECIMAL(12,2) NOT NULL,

  version INTEGER NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  created_by varchar(256),
  updated_at TIMESTAMP WITH TIME ZONE
);
