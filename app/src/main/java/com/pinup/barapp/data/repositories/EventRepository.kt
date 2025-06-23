package com.pinup.barapp.data.repositories

import com.pinup.barapp.R
import com.pinup.barapp.domain.models.Event
import com.pinup.barapp.domain.models.EventDetail

object EventRepository {
    val events = listOf(
        Event(
            id = 1,
            title = "Happy Hour!",
            description = "50% off cocktails from 6 PM to 8 PM. Enjoy the best mixes of the evening!",
            imageRes = R.drawable.event_happy_hour,
            detail = EventDetail(
                title = "Happy Hour – 50% Off Cocktails!",
                subtitle = "Every day from 6 PM to 8 PM",
                mainInfo = "Half-price on the entire cocktail menu. The perfect way to unwind after work with upbeat music, stylish decor and great bartenders.",
                timeTitle = "When:",
                timeValue = "Every day from 6 PM to 8 PM",
                featuresTitle = "Highlights",
                features = listOf(
                    "50% discount on all cocktails",
                    "Perfect excuse to relax after work",
                    "Pin-up atmosphere: energetic music, stylish interior and awesome bartenders"
                ),
                promoTitle = "Top cocktails at a special price:",
                promoList = listOf(
                    "Pina Colada – €4.99 instead of €9.99",
                    "Mojito – €3.99 instead of €7.99",
                    "Margarita – €4.49 instead of €8.99",
                    "Cosmopolitan – €4.99 instead of €9.99"
                ),
                extraTitle = null,
                extraList = null,
                howToTitle = "How to join:",
                howTo = "Just come to the bar during Happy Hour and order cocktails at the promo price. Grab your friends and kick off the night!"
            )
        ),
        Event(
            id = 2,
            title = "Burger & Pint",
            description = "Juicy burger plus a pint for only €9.99! Available every Tuesday.",
            imageRes = R.drawable.event_burger_pint,
            detail = EventDetail(
                title = "Burger & Pint – the perfect duo!",
                subtitle = "Every Tuesday, all day",
                mainInfo = "Beef burger with fresh veggies and our signature sauce plus a cold pint of your choice. Only €9.99 instead of €14.99.",
                timeTitle = "When:",
                timeValue = "Every Tuesday, all day",
                featuresTitle = "What’s included",
                features = listOf(
                    "Juicy beef burger with fresh vegetables and special sauce",
                    "A 500 ml pint of your choice: lager, dark or craft",
                    "All for €9.99 instead of €14.99!"
                ),
                promoTitle = null,
                promoList = null,
                extraTitle = "Extras:",
                extraList = listOf(
                    "Add fries for just +€1.99",
                    "Add a cheese topping for +€0.99"
                ),
                howToTitle = "How to order:",
                howTo = "Drop by on Tuesday and ask your server for the Burger & Pint special. Don’t miss tasty Tuesdays!"
            )
        ),
        Event(
            id = 3,
            title = "Match of the Day: Bet on Victory!",
            description = "Come watch the big match and get a free shot for every goal your team scores!",
            imageRes = R.drawable.event_match_day,
            detail = EventDetail(
                title = "Match of the Day: Bet on Victory!",
                subtitle = "Cheer and earn shots",
                mainInfo = "Free shot for each goal by your favorite team.",
                timeTitle = "When:",
                timeValue = "During top football matches (check schedule in the app)",
                featuresTitle = "В чем фишка?",
                features = listOf(
                    "Watch the best match of the day at Pin-up Sports Bar",
                    "Pick your team and cheer with all your heart",
                    "Enjoy a free shot whenever your team scores"
                ),
                promoTitle = "Bonuses:",
                promoList = listOf(
                    "Team specials – order a snack set and get beer discounts",
                    "Football atmosphere – big screens, live emotions and great company",
                    "Fan prizes – guess the exact score and win a signature cocktail"
                ),
                extraTitle = null,
                extraList = null,
                howToTitle = "How to participate:",
                howTo = "Come before kickoff, tell the waiter which team you support and enjoy free shots when they score!"
            )
        ),
        Event(
            id = 4,
            title = "Karaoke Night",
            description = "Every Friday from 10 PM – sing and get drink discounts! The best singer wins a prize!",
            imageRes = R.drawable.event_karaoke_night,
            detail = EventDetail(
                title = "Karaoke Night at Pin-up!",
                subtitle = "Every Friday at 10 PM",
                mainInfo = "Open mic and 20% off cocktails for all participants.",
                timeTitle = "When:",
                timeValue = "Every Friday at 10 PM",
                featuresTitle = "What to expect",
                features = listOf(
                    "Open mic for everyone!",
                    "20% discount on cocktails for all participants.",
                    "Prize for the best singer – a signature cocktail from the bartender!"
                ),
                promoTitle = null,
                promoList = null,
                extraTitle = "How to become the star of the night",
                extraList = listOf(
                    "Choose your favorite song.",
                    "Captivate the crowd with your voice and charisma.",
                    "Earn free shots for the hottest performances!"
                ),
                howToTitle = "How to participate:",
                howTo = "Just show up, register with the host and sing for fun! Friday night is time to shine. See you at Pin-up!"
            )
        ),
        Event(
            id = 5,
            title = "Whiskey & Poker Night",
            description = "Play friendly poker and get 20% off all whiskey.",
            imageRes = R.drawable.event_whiskey_poker,
            detail = EventDetail(
                title = "Whiskey & Poker Night at Pin-up!",
                subtitle = "Every Wednesday at 8 PM",
                mainInfo = "Poker night with 20% off whiskey and special sets.",
                timeTitle = "When:",
                timeValue = "Every Wednesday at 8 PM",
                featuresTitle = "What to expect",
                features = listOf(
                    "Atmospheric poker evening with like-minded folks.",
                    "20% discount on all whiskey for participants.",
                    "Special poker sets with snacks and drinks.",
                    "Nice bonuses for lucky hands!"
                ),
                promoTitle = null,
                promoList = null,
                extraTitle = "Bonus game:",
                extraList = listOf(
                    "Flush – free whiskey shot",
                    "Full house – 30% off any cocktail",
                    "Straight flush – signature cocktail from the bartender as a gift"
                ),
                howToTitle = "How to participate:",
                howTo = "Come on Wednesday and register with the host. Play friendly poker, enjoy whiskey and the vibe. Try your luck and get exclusive bonuses! Spend the evening Pin-up style – great fun and great whiskey!"
            )
        ),
        Event(
            id = 6,
            title = "Girls' Night at Pin-up!",
            description = "Complimentary cocktail for every lady with orders over €20.",
            imageRes = R.drawable.event_hen_party,
            detail = EventDetail(
                title = "Girls' Night at Pin-up!",
                subtitle = "Every Saturday at 8 PM",
                mainInfo = "Free cocktail with orders over €20. Vibrant atmosphere and special sets for bachelorette parties.",
                timeTitle = "When:",
                timeValue = "Every Saturday at 8 PM",
                featuresTitle = "What to expect",
                features = listOf(
                    "Free cocktail for every lady with a €20 order.",
                    "Bright Pin-up vibe – stylish decor, music and special photo zones.",
                    "Special snack and cocktail sets for loud bachelorette parties.",
                    "DJ sets and themed parties."
                ),
                promoTitle = null,
                promoList = null,
                extraTitle = "Compliment of choice:",
                extraList = listOf(
                    "\"Pink Lady\" – delicate taste with hints of vanilla and pomegranate.",
                    "\"Margarita Passion\" – classic with a fruity twist.",
                    "\"Sex on the Beach\" – iconic cocktail for a bright night."
                ),
                howToTitle = "How to use:",
                howTo = "Gather your girlfriends and come on Saturday night. Order your favorite food and drinks, get a free cocktail and enjoy the party! Mood – flirt, style – Pin-up, drinks – perfect!"
            )
        ),
        Event(
            id = 7,
            title = "Birthday at Pin-up!",
            description = "Birthday guests get a free shot set! Just show your ID and celebrate loudly!",
            imageRes = R.drawable.event_birthday,
            detail = EventDetail(
                title = "Birthday at Pin-up!",
                subtitle = "Shot set and discounts for your group",
                mainInfo = "Celebrate brightly – get a shot set and a personal cocktail!",
                timeTitle = "When:",
                timeValue = "On your birthday and three days after",
                featuresTitle = "How we congratulate",
                features = listOf(
                    "Shot set gift for the birthday person!",
                    "10% off the entire order for your party.",
                    "Option to order a personal cocktail named after the birthday guest.",
                    "Bright congratulations from the bar team and a festive atmosphere!"
                ),
                promoTitle = null,
                promoList = null,
                extraTitle = "Bonus:",
                extraList = listOf(
                    "If your group has 6 or more people, we'll throw in an extra cocktail!"
                ),
                howToTitle = "How to use:",
                howTo = "Come on your birthday or within three days after. Show your ID to the staff, get a shot set and celebrate in style! It's your day – our treats! See you at Pin-up!"
            )
        )
    )

    fun getEventById(id: Int): Event? = events.find { it.id == id }
}
