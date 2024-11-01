package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository


@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(16.dp))

    ) {

        Row{
           Column(
               modifier = Modifier.padding(end = 16.dp)
           ) {
               Text(
                   text = stringResource(id = hero.nameRes),
                   style = MaterialTheme.typography.displaySmall
               )
               Text(
                   text = stringResource(id = hero.descriptionRes),
                   style = MaterialTheme.typography.bodyLarge
               )
           }
            Box (
                modifier = Modifier.height(72.dp)
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = null,
                    Modifier.clip(shape = RoundedCornerShape(8.dp)))
            }
            }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewHeroCard() {

    val heroes = HeroesRepository.heroes

    HeroCard(hero = heroes[1])
}
