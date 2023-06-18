ALTER TABLE budget_plans
    DROP COLUMN is_recurring,
    ADD COLUMN plan_type varchar(32) NOT NULL;