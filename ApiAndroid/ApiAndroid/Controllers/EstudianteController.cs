using System.Threading.Tasks;
using ApiAndroid.DTOs;
using ApiAndroid.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace ApiAndroid.Controllers
{
    [ApiController]
    [Route("proyectoFinal")]
    public class EstudianteController : ControllerBase
    {
        private readonly EstudiantesContext _context;
        public EstudianteController(EstudiantesContext context) { 
        
            _context = context;
        }
        [HttpGet]
        [Route("Estudiante")]
        public IActionResult ListarEstudiante()
        {

            var estudiante = _context.Estudiantes
                .Include(e=>e.Nota)
                .Select(e =>
            new EstudianteDto
            {
                IdEstudiante = e.IdEstudiante,
                NombreEstudiante = e.NombreEstudiante,
                ProgramaEstudiante = e.ProgramaEstudiante,
                NotaEstudiante = e.Nota.Select(n => n.NotaFinal).FirstOrDefault()

            }).ToArray();

            return Ok(estudiante);
        }

        [HttpPost]
        [Route("RegistrarEstudiante")]
        public async Task<IActionResult> RegistrarEstudiante([FromBody] EstudianteDto estudiante)
        {
            var newEstudiante = new Estudiante
            {
                IdEstudiante = estudiante.IdEstudiante,
                NombreEstudiante = estudiante.NombreEstudiante,
                ProgramaEstudiante = estudiante.ProgramaEstudiante,
            };

            

            if(ModelState.IsValid)
            {
                _context.Estudiantes.Add(newEstudiante);
                await _context.SaveChangesAsync();

                var nota = new Notum
                {
                    IdEstudiante = estudiante.IdEstudiante,
                    NotaFinal = estudiante.NotaEstudiante
                };

                _context.Nota.Add(nota);
                await _context.SaveChangesAsync();

                return Ok(newEstudiante);
            }

            return NotFound("Datos incorrectos");
        }

        [HttpDelete]
        [Route("EliminarEstudiante/{id}")]
        public async Task<IActionResult> EliminarEstudiante(int id)
        {
            var eliminarEstudiante = _context.Estudiantes.Include(e=>e.Nota).FirstOrDefault(e=>e.IdEstudiante == id);

            if (eliminarEstudiante != null)
            {
                _context.Nota.RemoveRange(eliminarEstudiante.Nota);
                await _context.SaveChangesAsync();

                _context.Estudiantes.Remove(eliminarEstudiante);
                await _context.SaveChangesAsync();
                return Ok(eliminarEstudiante);
            }

            return NotFound("id incorrecto");
        }

        [HttpPut]
        [Route("ActualizarEstudiante/{id}")]
        public async Task<IActionResult> ActualizarEstudiante(int id, [FromBody] EstudianteDto estudiante)
        {
            var actualizarEstudiante = _context.Estudiantes.FirstOrDefault(e => e.IdEstudiante == id);
            var nota = _context.Nota.FirstOrDefault(e => e.IdEstudiante == id);

            if (actualizarEstudiante != null)
            {
                actualizarEstudiante.NombreEstudiante = estudiante.NombreEstudiante;
                actualizarEstudiante.ProgramaEstudiante = estudiante.ProgramaEstudiante;

                if (nota != null)
                {
                    nota.NotaFinal = estudiante.NotaEstudiante;
                }
                _context.SaveChangesAsync();
                return Ok("Datos actualizados correctamente");
            }
            return NotFound("Datos incorrectos");
        }
    }
}
