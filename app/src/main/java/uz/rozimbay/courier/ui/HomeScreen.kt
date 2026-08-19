package uz.rozimbay.courier.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.rozimbay.courier.ui.theme.*

private data class NavEntry(val icon: String, val label: String)

private val bottomNavItems = listOf(
    NavEntry("🏠", "Bosh sahifa"),
    NavEntry("📦", "Buyurtma"),
    NavEntry("🛵", "Kuryer"),
    NavEntry("💳", "Narxlar"),
    NavEntry("☎️", "Aloqa"),
)

@Composable
fun RozimbayHomeScreen() {
    val auroraBrush = Brush.radialGradient(
        colors = listOf(Violet.copy(alpha = 0.35f), Ink),
        radius = 900f
    )

    Scaffold(
        containerColor = Ink,
        bottomBar = { RozimbayBottomBar() }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(auroraBrush)
                .padding(padding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                TopLocationBar()
                BentoGrid(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
private fun TopLocationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .glass(CircleShape)
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("📍 Toshkent", color = TextSecondary, fontSize = 13.sp)
        }
        Box(
            modifier = Modifier
                .background(Brush.horizontalGradient(listOf(Violet, Pink)), CircleShape)
                .padding(horizontal = 18.dp, vertical = 10.dp)
        ) {
            Text("Buyurtma berish", color = TextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
        }
    }
}

@Composable
private fun BentoGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(horizontal = 16.dp),
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item(span = { GridItemSpan(2) }) { HeroTile() }
        item { LiveRouteTile() }
        item { QuickStatTile() }
        item(span = { GridItemSpan(2) }) { CourierCtaTile() }
        item { HowItWorksTile() }
        item { TestimonialTile() }
    }
}

@Composable
private fun HeroTile() {
    GlassCard {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(Brush.linearGradient(listOf(Violet, Pink)), CircleShape)
                )
                Spacer(Modifier.width(8.dp))
                Text("Toshkent bo'ylab yetkazib berish", color = AccentVioletLight, fontSize = 12.sp)
            }
            Spacer(Modifier.height(12.dp))
            Text(
                "Buyurtmangiz uchun bitta shaffof panel.",
                style = MaterialTheme.typography.headlineLarge,
                color = TextPrimary
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "Manzilni belgilang, kuryer tayinlanadi, jarayonni shu yerdan kuzatib borasiz.",
                style = MaterialTheme.typography.bodyLarge,
                color = TextSecondary
            )
            Spacer(Modifier.height(18.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(28.dp)) {
                StatMini("12 daq", "o'rtacha")
                StatMini("450+", "kuryer")
                StatMini("24/7", "ishlaydi")
            }
        }
    }
}

@Composable
private fun StatMini(value: String, label: String) {
    Column {
        Text(value, color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 17.sp)
        Text(label, color = TextMuted, fontSize = 11.sp)
    }
}

@Composable
private fun LiveRouteTile() {
    GlassCard {
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Text("Jonli holat", color = TextMuted, fontSize = 11.sp)
            Column {
                Text("Kuryer yo'lda 🛵", color = TextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Text("Chilonzor → Yunusobod", color = TextSecondary, fontSize = 11.sp)
            }
            Text("8 daq", color = AccentVioletLight, fontWeight = FontWeight.Bold, fontSize = 22.sp)
        }
    }
}

@Composable
private fun QuickStatTile() {
    GlassCard {
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Text("Bugungi buyurtmalar", color = TextMuted, fontSize = 11.sp)
            Text("1 284", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 26.sp)
            Text("↑ 12% kechagiga nisbatan", color = Cyan, fontSize = 11.sp)
        }
    }
}

@Composable
private fun CourierCtaTile() {
    GlassCard {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Kuryer bo'lib ishlang", color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("O'z jadvalingiz, aniq haq, tez to'lov.", color = TextSecondary, fontSize = 12.sp)
            }
            Box(
                modifier = Modifier
                    .background(GlassStrong, RoundedCornerShape(50))
                    .border(1.dp, GlassBorder, RoundedCornerShape(50))
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                Text("Ro'yxatdan o'tish", color = TextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun HowItWorksTile() {
    GlassCard {
        Column {
            Text("Qanday ishlaydi", color = TextMuted, fontSize = 11.sp)
            Spacer(Modifier.height(10.dp))
            listOf("Buyurtma bering", "Kuryer oladi", "Yetkazib beriladi").forEachIndexed { i, step ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .background(Brush.linearGradient(listOf(Violet, Pink)), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("${i + 1}", color = TextPrimary, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(step, color = TextSecondary, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
private fun TestimonialTile() {
    GlassCard {
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Text("★★★★★", color = AmberStar, fontSize = 13.sp)
            Text(
                "\"Buyurtmam 10 daqiqada yetib keldi, hammasi aniq ko'rinib turardi.\"",
                color = TextSecondary,
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
            Text("— Madina, mijoz", color = TextMuted, fontSize = 11.sp)
        }
    }
}

@Composable
private fun RozimbayBottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Ink)
            .border(width = 1.dp, color = GlassBorder)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        bottomNavItems.forEachIndexed { i, item ->
            val active = i == 0
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(item.icon, fontSize = 18.sp)
                Spacer(Modifier.height(2.dp))
                Text(
                    item.label,
                    fontSize = 9.sp,
                    color = if (active) TextPrimary else TextMuted
                )
            }
        }
    }
}

/** Reusable frosted-glass card matching the web version's `.glass` style. */
@Composable
private fun GlassCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .glass(RoundedCornerShape(24.dp))
            .padding(18.dp)
    ) {
        content()
    }
}

private fun Modifier.glass(shape: androidx.compose.ui.graphics.Shape) = this
    .clip(shape)
    .background(GlassWhite)
    .border(1.dp, GlassBorder, shape)
