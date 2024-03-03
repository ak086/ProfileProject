import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.razorpay.Checkout
import kotlinx.coroutines.launch
import org.json.JSONObject

@Composable
fun PaymentScreen() {
    var paymentAmount by remember { mutableStateOf("") }
    var paymentResult by remember { mutableStateOf<PaymentResult?>(null) }
    val context = LocalContext.current
    val activity = (context as? ComponentActivity)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter Payment Details",
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Input field for payment amount
        TextField(
            value = paymentAmount,
            onValueChange = { paymentAmount = it },
            label = { Text("Enter Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Payment button
        Button(
            onClick = {
                startRazorpayPayment(activity, paymentAmount) { result ->
                    paymentResult = result
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Proceed to Payment")
        }

        // Display payment result
        paymentResult?.let { result ->
            Text(text = "Payment Result: ${result.status}")
        }
    }
}

sealed class PaymentResult(val status: String) {
    object Success : PaymentResult("Success")
    object Failure : PaymentResult("Failure")
}

fun startRazorpayPayment(activity: ComponentActivity?, paymentAmount: String, onPaymentResult: (result: PaymentResult) -> Unit) {
    activity?.let {
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_20pT4wY5ydSFz9")

        try {
            val options = JSONObject().apply {
                put("name", "Your App Name")
                put("description", "Payment for XYZ")
                put("currency", "INR")
                put("amount", paymentAmount)
            }

            checkout.open(activity, options)
            activity.lifecycleScope.launch {
                kotlinx.coroutines.delay(3000) // Simulating payment processing delay
                val paymentResult = if (paymentAmount.toInt() % 2 == 0) PaymentResult.Success else PaymentResult.Failure
                onPaymentResult(paymentResult)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Preview
@Composable
fun PaymentScreenPreview(@PreviewParameter(PaymentAmountProvider::class) paymentAmount: String = "100") {
    PaymentScreen()
}

class PaymentAmountProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf("100", "200", "500")
}