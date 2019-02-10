SELECT pid, p.name pname, s.name sname, pr.name prname, pr.price
    FROM mystore.product AS p, mystore.supplier AS s, mystore.price AS pr
    WHERE p.sid = s.sid AND
        p.pgid = pr.pgid AND
        pr.name = 'pos' AND
        CURDATE() BETWEEN pr.date_from AND pr.date_to;