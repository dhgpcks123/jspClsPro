INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man1', 'img_avatar1.png', '/img/avatar/', 0, 'M'
);
INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man2', 'img_avatar2.png', '/img/avatar/', 0, 'M'
);
INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man3', 'img_avatar3.png', '/img/avatar/', 0, 'M'
);
INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man4', 'img_avatar4.png', '/img/avatar/', 0, 'F'
);
INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man5', 'img_avatar5.png', '/img/avatar/', 0, 'F'
);
INSERT INTO avatar(ano, aname, afile, dir, len, gen)
VALUES(
    (SELECT NVL(MAX(ano)+1, 11)FROM avatar),
    'man6', 'img_avatar6.png', '/img/avatar/', 0, 'F'
);
