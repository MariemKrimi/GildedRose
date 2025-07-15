# Kata de Refactoring : Gilded Rose

## Spécifications des exigences

Bonjour et bienvenue dans l'équipe de Gilded Rose.

Comme vous le savez, nous sommes une petite auberge située dans un emplacement privilégié d'une ville importante, dirigée par une aubergiste sympathique nommée Allison.

Nous achetons et vendons uniquement les articles les plus fins. Malheureusement, la qualité de nos marchandises se dégrade constamment à l'approche de leur date de péremption.

Nous avons un système qui met à jour notre inventaire automatiquement. Il a été développé par un certain Leeroy, un type sans-non-sens qui est parti vivre de nouvelles aventures.

> Votre tâche consiste à ajouter une nouvelle fonctionnalité à notre système pour que nous puissions commencer à vendre une nouvelle catégorie d'articles. 

Tout d'abord, une introduction à notre système :

	- Tous les articles ont une valeur SellIn qui indique le nombre de jours restants pour vendre l'article
    - Tous les articles ont une valeur Quality qui indique la valeur de l'article
    - À la fin de chaque jour, notre système diminue ces deux valeurs pour chaque article

Assez simple, non ? Voici où ça devient intéressant :

	- Une fois la date de péremption passée, la Quality se dégrade deux fois plus vite
    - La Quality d'un article ne peut jamais être négative
    - Le "Aged Brie" voit sa Quality augmenter avec le temps
    - La Quality d'un article ne peut jamais dépasser 50
    - "Sulfuras", étant un objet légendaire, n'a pas besoin d'être vendu et ne perd jamais en Quality
    - Les "Backstage passes", comme le Aged Brie, voient leur Quality augmenter à l'approche de la date de concert :
	    - La Quality augmente de 2 quand il reste 10 jours ou moins
	    - Et de 3 quand il reste 5 jours ou moins
	    - Mais la Quality tombe à 0 après le concert

Nous avons récemment signé un contrat avec un fournisseur d'objets "Conjured". Cela nécessite une mise à jour de notre système :

	-Les articles "Conjured" voient leur Quality se dégrader deux fois plus vite que les articles normaux

`N'hésitez pas à modifier la méthode UpdateQuality et à ajouter du nouveau code tant que tout continue à fonctionner correctement.` 

Cependant, ne modifiez pas la classe Item ni la propriété Items car elles appartiennent au gobelin dans le coin qui entrera dans une rage instantanée et vous éliminera d'un coup, car il ne croit pas au partage de propriété du code (vous pouvez rendre la méthode UpdateQuality et la propriété Items statiques si vous voulez, on vous couvrira).

Pour clarifier, un article ne peut jamais voir sa Quality dépasser 50, mais "Sulfuras" est un objet légendaire avec une Quality fixe à 80 qui ne change jamais.

