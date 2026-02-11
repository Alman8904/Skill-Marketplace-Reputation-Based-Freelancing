-- V4__seed_test_data.sql
-- Minimal seed data for demonstration & testing
-- ALL TEST USERS PASSWORD: "password123"
-- BCrypt hash used below:
-- $2a$10$hV5uBnwQm92viwY8j5kQO.ogRz5WQ0kPbKulAClRVdZZK34NxzXbS

-- ============================================================
-- CATEGORIES
-- ============================================================
INSERT INTO category (category_id, category_name) VALUES
(1, 'Technology'),
(2, 'Design');

-- ============================================================
-- SKILLS
-- ============================================================
INSERT INTO skill (id, skill_name, category_id) VALUES
(1, 'Web Development', 1),
(2, 'Python Programming', 1),
(3, 'UI/UX Design', 2);

-- ============================================================
-- USERS
-- ============================================================
INSERT INTO user_model (
    id,
    username,
    first_name,
    last_name,
    password,
    user_type,
    wallet_balance
) VALUES

-- Consumer
(100,
 'consumer1',
 'John',
 'Doe',
 '$2a$10$hV5uBnwQm92viwY8j5kQO.ogRz5WQ0kPbKulAClRVdZZK34NxzXbS',
 'CONSUMER',
 500.00
),

-- Provider 1
(101,
 'dev1',
 'Sarah',
 'Lee',
 '$2a$10$hV5uBnwQm92viwY8j5kQO.ogRz5WQ0kPbKulAClRVdZZK34NxzXbS',
 'PROVIDER',
 100.00
),

-- Provider 2
(102,
 'designer1',
 'Mike',
 'Chen',
 '$2a$10$hV5uBnwQm92viwY8j5kQO.ogRz5WQ0kPbKulAClRVdZZK34NxzXbS',
 'PROVIDER',
 150.00
);

-- ============================================================
-- PROVIDER SKILLS
-- ============================================================
INSERT INTO user_skill (
    user_skill_id,
    description,
    rate,
    experience,
    is_active,
    service_mode,
    user_id,
    skill_id
) VALUES

(1,
 'Full-stack web applications using Spring Boot',
 50.00,
 3,
 true,
 'REMOTE',
 101,
 1
),

(2,
 'Python automation and scripting',
 40.00,
 2,
 true,
 'REMOTE',
 101,
 2
),

(3,
 'Modern UI/UX design for web apps',
 45.00,
 4,
 true,
 'REMOTE',
 102,
 3
);

-- ============================================================
-- SAMPLE ORDER
-- ============================================================
INSERT INTO orders (
    order_id,
    consumer_id,
    provider_id,
    skill_id,
    description,
    agreed_price,
    status,
    created_at,
    estimated_hours
) VALUES

(1,
 100,
 101,
 1,
 'Build a landing page for startup',
 250.00,
 'COMPLETED',
 CURRENT_TIMESTAMP - INTERVAL '5 days',
 6
);

-- ============================================================
-- RESET SEQUENCES
-- ============================================================
SELECT setval('category_category_id_seq', (SELECT MAX(category_id) FROM category));
SELECT setval('skill_id_seq', (SELECT MAX(id) FROM skill));
SELECT setval('user_model_id_seq', (SELECT MAX(id) FROM user_model));
SELECT setval('user_skill_user_skill_id_seq', (SELECT MAX(user_skill_id) FROM user_skill));
SELECT setval('orders_order_id_seq', (SELECT MAX(order_id) FROM orders));

-- ============================================================
-- TEST CREDENTIALS
-- ============================================================
-- Password for ALL users: password123
--
-- Consumer:
--   username: consumer1
--   role: CONSUMER
--
-- Providers:
--   username: dev1
--   role: PROVIDER
--
--   username: designer1
--   role: PROVIDER
--
-- Admin:
--   Created separately via DataInitializer
-- ============================================================
