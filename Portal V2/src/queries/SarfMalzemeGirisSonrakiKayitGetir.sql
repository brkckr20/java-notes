SELECT 
	d1.id,d1.tarih,d1.firma_kodu,d1.firma_unvan,d1.fatura_no,
	d2.kalem_islem,d2.malzeme_kodu,d2.malzeme_adi,d2.miktar,d2.birim,d2.`uuid`
FROM sarf_malzeme_depo1 d1
INNER JOIN sarf_malzeme_depo2 d2 ON d1.id = d2.refNoId
WHERE d1.islem_cinsi = 'SARF_MALZEME_GIRIS' AND d1.id = (
SELECT MIN(id)
FROM sarf_malzeme_depo1
WHERE id > ?)