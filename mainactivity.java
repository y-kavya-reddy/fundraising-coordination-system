package com.example.crisisresponseapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crisisresponseapp.ui.theme.CrisisResponseTheme
import androidx.compose.material3.TextField as TextField1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrisisResponseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val showVerification = remember { mutableStateOf(false) }
    val showFundraising = remember { mutableStateOf(false) }
    val showEmergency = remember { mutableStateOf(false) }
    val showVolunteer = remember { mutableStateOf(false) }
    val showDonorRelationship = remember { mutableStateOf(false) }
    val showEmergencyAssistance = remember { mutableStateOf(false) }
    val showVolunteerRecruitment = remember { mutableStateOf(false) }
    val toastMessage = remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    toastMessage.value?.let { message ->
        LaunchedEffect(message) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            toastMessage.value = null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        when {
            showVerification.value -> VerificationScreen {
                showVerification.value = false
                toastMessage.value = "Verification completed successfully!"
            }
            showFundraising.value -> FundraisingScreen {
                showFundraising.value = false
                toastMessage.value = "Fundraising campaign created successfully!"
            }
            showEmergency.value -> EmergencyScreen {
                showEmergency.value = false
                toastMessage.value = "Emergency response recorded successfully!"
            }
            showVolunteer.value -> VolunteerScreen {
                showVolunteer.value = false
                toastMessage.value = "Volunteer details updated successfully!"
            }
            showDonorRelationship.value -> DonorRelationshipScreen {
                showDonorRelationship.value = false
                toastMessage.value = "Donor relationship enhanced successfully!"
            }
            showEmergencyAssistance.value -> EmergencyAssistanceScreen {
                showEmergencyAssistance.value = false
                toastMessage.value = "Emergency assistance requested successfully!"
            }
            showVolunteerRecruitment.value -> VolunteerRecruitmentScreen {
                showVolunteerRecruitment.value = false
                toastMessage.value = "Volunteer recruitment successful!"
            }
            else -> Dashboard(
                onVerification = { showVerification.value = true },
                onFundraising = { showFundraising.value = true },
                onEmergency = { showEmergency.value = true },
                onVolunteer = { showVolunteer.value = true },
                onDonorRelationship = { showDonorRelationship.value = true },
                onEmergencyAssistance = { showEmergencyAssistance.value = true },
                onVolunteerRecruitment = { showVolunteerRecruitment.value = true }
            )
        }
    }
}

@Composable
fun Dashboard(
    onVerification: () -> Unit,
    onFundraising: () -> Unit,
    onEmergency: () -> Unit,
    onVolunteer: () -> Unit,
    onDonorRelationship: () -> Unit,
    onEmergencyAssistance: () -> Unit,
    onVolunteerRecruitment: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { onVerification() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Verification & Validation")
        }
        Button(
            onClick = { onFundraising() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Fundraising Campaign Management")
        }
        Button(
            onClick = { onEmergency() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Emergency Response Coordination")
        }
        Button(
            onClick = { onVolunteer() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Volunteer Management & Training")
        }
        Button(
            onClick = { onDonorRelationship() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Donor Relationship Enhancement")
        }
        Button(
            onClick = { onEmergencyAssistance() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Emergency Assistance Request")
        }
        Button(
            onClick = { onVolunteerRecruitment() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Volunteer Recruitment")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(onSubmit: () -> Unit) {
    var organizationName by remember { mutableStateOf(TextFieldValue("")) }
    var contactPerson by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Verification Process", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = organizationName,
            onValueChange = { organizationName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Organization Name") }
        )
        TextField1(
            value = contactPerson,
            onValueChange = { contactPerson = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Contact Person") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FundraisingScreen(onSubmit: () -> Unit) {
    var campaignName by remember { mutableStateOf(TextFieldValue("")) }
    var targetAmount by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Fundraising Campaign", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = campaignName,
            onValueChange = { campaignName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Campaign Name") }
        )
        TextField1(
            value = targetAmount,
            onValueChange = { targetAmount = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Target Amount") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyScreen(onSubmit: () -> Unit) {
    var emergencyType by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Emergency Response", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = emergencyType,
            onValueChange = { emergencyType = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Emergency Type") }
        )
        TextField1(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Description") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteerScreen(onSubmit: () -> Unit) {
    var volunteerName by remember { mutableStateOf(TextFieldValue("")) }
    var skills by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Volunteer Management", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = volunteerName,
            onValueChange = { volunteerName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Volunteer Name") }
        )
        TextField1(
            value = skills,
            onValueChange = { skills = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Skills") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonorRelationshipScreen(onSubmit: () -> Unit) {
    var donorName by remember { mutableStateOf(TextFieldValue("")) }
    var contactDetails by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Donor Relationship Enhancement", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = donorName,
            onValueChange = { donorName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Donor Name") }
        )
        TextField1(
            value = contactDetails,
            onValueChange = { contactDetails = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Contact Details") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmergencyAssistanceScreen(onSubmit: () -> Unit) {
    var assistanceType by remember { mutableStateOf(TextFieldValue("")) }
    var details by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Emergency Assistance Request", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = assistanceType,
            onValueChange = { assistanceType = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Assistance Type") }
        )
        TextField1(
            value = details,
            onValueChange = { details = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Details") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolunteerRecruitmentScreen(onSubmit: () -> Unit) {
    var volunteerRole by remember { mutableStateOf(TextFieldValue("")) }
    var numberOfVolunteers by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Volunteer Recruitment", style = MaterialTheme.typography.titleLarge)
        TextField1(
            value = volunteerRole,
            onValueChange = { volunteerRole = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Volunteer Role") }
        )
        TextField1(
            value = numberOfVolunteers,
            onValueChange = { numberOfVolunteers = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            placeholder = { Text("Enter Number of Volunteers Needed") }
        )
        Button(onClick = onSubmit, modifier = Modifier.padding(top = 16.dp)) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CrisisResponseTheme {
        MainScreen()
    }
}
