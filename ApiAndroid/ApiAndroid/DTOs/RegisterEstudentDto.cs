using ApiAndroid.Models;

namespace ApiAndroid.DTOs
{
    public class RegisterEstudentDto
    {
        public EstudianteDto Estudiante { get; set; } = new EstudianteDto();

        public List<Estudiante> ListEstudiante { get; set; } = new List<Estudiante>();
    }
}
