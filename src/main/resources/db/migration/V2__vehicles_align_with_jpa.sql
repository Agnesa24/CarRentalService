-- Align vehicles table with VehicleJpaEntity (model_year, condition_status, available)

ALTER TABLE vehicles ADD COLUMN available BOOLEAN NOT NULL DEFAULT TRUE;

UPDATE vehicles SET available = (UPPER(TRIM(status)) = 'AVAILABLE');

ALTER TABLE vehicles RENAME COLUMN vehicle_year TO model_year;
ALTER TABLE vehicles RENAME COLUMN status TO condition_status;
