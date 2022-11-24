import com.gapvak.athlete.service.AthleteService
import com.gapvak.athlete.service.StravaCalls

class BootStrap {

    AthleteService athleteService
    def init = { servletContext ->
        StravaCalls stravaCalls = new StravaCalls(athleteService)
        stravaCalls.start()
    }
    def destroy = {
    }
}
