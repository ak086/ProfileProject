package com.example.profileproject
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfilePage() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            ProfileCard()
            ProfileLevelCard()
            PrivacyPolicyCard()
            TermsAndConditionsCard()
        }
    }
}

@Composable
fun ProfileCard() {
    Box(
        modifier = Modifier
            .size(width = 340.dp, height = 200.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF5F6D),
                        Color(0xFFFFC371)
                    ),
                    startY = 0f,
                    endY = 400f
                )
            )
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Color.White)
                )
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "John Doe",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
@Composable
fun ProfileLevelCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.single),
                    contentDescription = "Level Image",
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "You're currently on Level 4 \nCheck your benefits",
                    maxLines = 2,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward Arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun PrivacyPolicyCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.privacy),
                    contentDescription = "Privacy Image",
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Privacy Policy",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward Arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
@Composable
fun TermsAndConditionsCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .wrapContentHeight(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Terms Image",
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Terms and Conditions",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward Arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfilePage() {
    ProfilePage()
}
