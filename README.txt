Compte rendu des modifications apportées à HeartStri après la soutenance 

1. Gestion correcte du mana
Initialisation du mana et du mana maximum à 1 pour chaque joueur au début de la partie.
À chaque début de tour, le mana maximum du joueur augmente de 1 (jusqu’à 10), puis le mana courant est remis à ce maximum.

2. Affichage du mana
Affichage du mana courant du joueur à chaque début de tour.
Affichage du coût en mana de chaque carte dans la main du joueur.

3. Vérification du mana avant activation d’une carte
Avant d’activer une carte (serviteur, arme ou sort), le jeu vérifie que le joueur a assez de mana.
Si le joueur n’a pas assez de mana pour la carte choisie, un message d’erreur s’affiche et il doit choisir une autre carte ou passer.

4. Blocage évité si aucune carte n’est jouable
Si aucune carte en main n’est jouable (pas assez de mana), le jeu affiche un message et passe automatiquement à la suite du tour.

5. Décrémentation du mana
Lorsqu’une carte est jouée, le coût en mana est bien retiré du mana courant du joueur.

6. Affichage amélioré
Affichage du mana, des points de vie et du nom du héros pour chaque joueur à chaque tour.
Affichage du coût en mana des serviteurs sur le plateau.
Affichage du pouvoir héroique 
7. Expérience utilisateur
Le joueur ne reste plus bloqué à choisir une carte s’il ne peut rien jouer.
Le jeu guide le joueur à chaque étape (choix de carte, attaque, utilisation du pouvoir héroïque).
