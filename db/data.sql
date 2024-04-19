INSERT INTO kunden_data
(Kundennummer, vorname, name)
VALUES (1, 'Simon', 'Amsler'),
       (2, 'Seth', 'Schmutz'),
       (3, 'Joshua', 'Kunz'),
       (4, 'Cem', 'Akkaya'),
       (5, 'Lorenz', 'Boss');

INSERT INTO kunden_service_data
(kunden_id, servicesdatum , servicesstatus, servicesbeschreibung)
VALUES (1, '2024-04-18' , 'open', 'forgot password'),
       (2, '2024-04-18' , 'open', 'help with account deletion'),
       (3, '2024-04-18' , 'closed', 'solved'),
       (4, '2024-04-18' , 'closed', 'solved'),
       (5, '2024-04-18', 'open', 'forgot password');

INSERT INTO auftrag_data
(kunden_id, auftragsdatum, auftragsnummer, auftragsstatus,bestellung)
VALUES (1, '2024-04-18', 1, 'open','Baby Dolls 15 pieces'),
       (1, '2024-04-18', 2, 'avaiting payment','Legos 100 packs'),
       (2, '2024-04-18', 3, 'deliverd','Playstation 5 1 piece'),
       (4, '2024-04-18', 4, 'sent','Xbox Series X 1 piece'),
       (5, '2024-04-18', 5, 'open','Dolls 15 pieces');

INSERT INTO requests_data
(vorname, name)
VALUES  ('Simon', 'Amsler'),
        ('Seth', 'Schmutz'),
        ('Joshua', 'Kunz'),
        ('Cem', 'Akkaya'),
        ('Lorenz', 'Boss'),
        ('Newt', 'Scamander'),
        ('Albus', 'Dumbledore'),
        ('Harry', 'Potter'),
        ('Hermione', 'Granger'),
        ('Ron', 'Weasley');