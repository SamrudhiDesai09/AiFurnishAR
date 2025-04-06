create extension if not exists "uuid-ossp";

CREATE TABLE IF NOT EXISTS furniture (
  id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  category text,
  name text,
  image_url text,
  tags text[]
);
