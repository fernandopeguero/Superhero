package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository
import com.example.superhero.ui.theme.SuperheroTheme


@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }

}


@Composable
fun HeroList(heroes: List<Hero>, modifier: Modifier = Modifier) {

    LazyColumn {
        items(heroes) { hero ->
            HeroCard(hero = hero, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
    }

}


@Composable
fun HeroApp() {

    val heroes = HeroesRepository.heroes

    HeroList(heroes = heroes)
}
@Preview(showBackground = true)
@Composable
fun PreviewHeroApp() {

    SuperheroTheme(darkTheme = false) {
        val heroes = HeroesRepository.heroes

        HeroList(heroes = heroes)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDarkHeroApp() {
    SuperheroTheme(darkTheme = true) {
        val heroes = HeroesRepository.heroes

        HeroList(heroes = heroes)
    }

}
