SELECT
	kalem_islem,
    malzeme_kodu,
    malzeme_adi,
    birim,
    
    SUM(miktar) - IFNULL(
        (
            SELECT SUM(miktar)
            FROM sarf_malzeme_depo1 x
            INNER JOIN sarf_malzeme_depo2 y ON x.id = y.refNoId
            WHERE islem_cinsi = 'SARF_MALZEME_GIRIS' AND Y.`uuid` = d2.`uuid`
        ), 0) AS kalan_miktar
        ,`uuid`
FROM sarf_malzeme_depo1 d1
INNER JOIN sarf_malzeme_depo2 d2 ON d1.id = d2.refNoId
WHERE islem_cinsi = 'SARF_MALZEME_CIKIS' AND d2.kalem_islem IN ('TAMİRE ÇIKIŞ','DOLUMA ÇIKIŞ')
GROUP BY kalem_islem,malzeme_kodu, malzeme_adi, birim,`uuid`
HAVING (SUM(miktar) - IFNULL(
        (
            SELECT SUM(miktar)
            FROM sarf_malzeme_depo1 x
            INNER JOIN sarf_malzeme_depo2 y ON x.id = y.refNoId
            WHERE islem_cinsi = 'SARF_MALZEME_GIRIS' AND y.`uuid` = d2.`uuid`
        ), 0)) <> 0;
