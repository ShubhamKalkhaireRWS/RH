Feature: feature to test hardware functionality
	
 @smoketest
 Scenario: Check RH is launching successfully
  
  	Given user is on product page using "<link>"
    When expand all details
    Then gather information from product page
    Then comapare "<details>" and "<dimentions>"
    
Examples:
|link	|details	|dimentions	|
#|https://rh.com/de/de/catalog/product/product.jsp?productId=prod7711183 |Hergestellt aus massivem, weißem Marmor mit satiniertem Finish~Die natürliche Maserung ist bei jedem Stück einzigartig~Nur für dekorative Zwecke; nicht lebensmittelecht |15 cm ⌀, 23 cm H Gewicht: 4,5 kg |
|https://rh.com/de/de/catalog/product/product.jsp?productId=prod7710577 |Hergestellt aus massivem, weißem Marmor mit satiniertem Finish~Die natürliche Maserung ist bei jedem Stück einzigartig~Nur für dekorative Zwecke; nicht lebensmittelecht |15 cm ⌀, 28 cm H~Gewicht: 4,1 kg |
#|https://rh.com/de/de/catalog/product/product.jsp?productId=prod7120073 |Runder Formholzrahmen, umgeben von geschnitzten Holzsonnenstrahlen~Handbemaltes, antikisiertes Blattsilber~Rückseite aus Holz~Inklusive Befestigungsmaterial~Bei Spiegeln mit einem Gewicht von mehr als 22,7 kg und bei der Montage auf einer Fliesen- oder Steinoberfläche ist eine professionelle Installation erforderlich. Der RH-Lieferservice beinhaltet keine Installation.|107 cm ⌀, 6 cm T.; 17,2 kg |
#|https://rh.com/de/de/catalog/product/product.jsp?productId=prod7760051&clientrender=true |
