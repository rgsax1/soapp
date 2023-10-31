INSERT INTO soapp.maintenance_mechanical (type) VALUES
('Verificar a pressão dos pneus'),
('Tensionar as correias do motor'),
('Trocar o filtro de óleo'),
('Verificar os freios'),
('Limpar o radiador'),
('Inspecionar os amortecedores'),
('Trocar as velas de ignição'),
('Ajustar o sistema de escapamento'),
('Verificar o sistema de direção'),
('Trocar o filtro de ar');

INSERT INTO soapp.maintenance_electrical (type) VALUES
('Verificar a fiação elétrica'),
('Substituir fusíveis queimados'),
('Limpar os contatos elétricos'),
('Testar a bateria'),
('Verificar as lâmpadas e faróis'),
('Revisar o sistema de ignição'),
('Inspeção do alternador'),
('Verificar os sensores elétricos'),
('Calibrar o sistema de áudio'),
('Trocar a bateria do controle remoto');


-- Inserir 10 registros aleatórios na tabela tb_user
INSERT INTO soapp.tb_user (first_name, job_title, last_name, password, user_access_level, user_name)
VALUES
  ('John', 'Engineer', 'Doe', 'password123', FLOOR(RAND() * 3), 'johndoe'),
  ('Jane', 'Manager', 'Smith', 'pass456', FLOOR(RAND() * 3), 'janesmith'),
  ('Alice', 'Developer', 'Johnson', 'pass789', FLOOR(RAND() * 3), 'alicejohnson'),
  ('Bob', 'Designer', 'Brown', 'secret123', FLOOR(RAND() * 3), 'bobbrown'),
  ('Eve', 'Tester', 'Davis', 'test456', FLOOR(RAND() * 3), 'evedavis'),
  ('Charlie', 'Analyst', 'Miller', 'data123', FLOOR(RAND() * 3), 'charliemiller'),
  ('Olivia', 'Manager', 'White', 'secure123', FLOOR(RAND() * 3), 'oliviawhite'),
  ('William', 'Engineer', 'Wilson', 'pwd123', FLOOR(RAND() * 3), 'williamwilson'),
  ('Sophia', 'Designer', 'Martinez', 'p@ssword', FLOOR(RAND() * 3), 'sophiamartinez'),
  ('Michael', 'Tester', 'Harris', 'random123', FLOOR(RAND() * 3), 'michaelharris');

INSERT INTO soapp.equipment (equipment_manufacturer, equipment_model, equipment_name, equipment_sector)
VALUES
    ('ZiperCorp', 'ZP1000', 'Máquina de Produção de Zíperes 1', 'Produção de Zíperes'),
    ('ZiperTech', 'ZipMaster 2000', 'Máquina de Produção de Zíperes 2', 'Produção de Zíperes'),
    ('ZiperTech', 'ZipPro X3', 'Máquina de Produção de Zíperes 3', 'Produção de Zíperes'),
    ('FastZips', 'FZ-500', 'Máquina de Produção de Zíperes 4', 'Produção de Zíperes'),
    ('ZipItUp', 'ZipMaster 3000', 'Máquina de Produção de Zíperes 5', 'Produção de Zíperes'),
    ('ZiperCorp', 'ZP2000', 'Máquina de Produção de Zíperes 6', 'Produção de Zíperes'),
    ('FastZips', 'FZ-1000', 'Máquina de Produção de Zíperes 7', 'Produção de Zíperes'),
    ('ZiperTech', 'ZipPro X5', 'Máquina de Produção de Zíperes 8', 'Produção de Zíperes'),
    ('ZipItUp', 'ZipMaster 4000', 'Máquina de Produção de Zíperes 9', 'Produção de Zíperes'),
    ('ZiperCorp', 'ZP3000', 'Máquina de Produção de Zíperes 10', 'Produção de Zíperes');
