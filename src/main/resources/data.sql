INSERT INTO kunden_data
(Kundennummer, vorname, name)
VALUES (1, 'Simon', 'Amsler'),
       (2, 'Seth', 'Schmutz'),
       (3, 'Joshua', 'Kunz'),
       (4, 'Cem', 'Akkaya'),
       (5, 'Lorenz', 'Boss');

INSERT INTO kunden_service_data
(Kundennummer, servicesdatum, servicesnummer, servicesstatus, servicesbeschreibung)
VALUES (1, '2024-04-18', 001, 'open', 'forgot password'),
       (2, '2024-04-18', 002, 'open', 'help with account deletion'),
       (3, '2024-04-18', 003, 'closed', 'solved'),
       (4, '2024-04-18', 004, 'closed', 'solved'),
       (5, '2024-04-18', 005, 'open', 'forgot password');

INSERT INTO auftrag_data
(Kundennummer, auftragsdatum, auftragsnummer, auftragsstatus)
VALUES (1, '2024-04-18', 1, 'open'),
       (1, '2024-04-18', 2, 'avaiting payment'),
       (2, '2024-04-18', 3, 'deliverd'),
       (4, '2024-04-18', 4, 'sent'),
       (5, '2024-04-18', 5, 'open');

INSERT INTO requests_data
(vorname, name)
VALUES ('Newt', 'Scamander'),
       ('Albus', 'Dumbledore'),
       ('Harry', 'Potter'),
       ('Hermione', 'Granger'),
       ('Ron', 'Weasley');