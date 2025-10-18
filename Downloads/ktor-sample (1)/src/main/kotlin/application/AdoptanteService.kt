package com.patitas_web.application

import com.patitas_web.domain.Adoptante
import com.patitas_web.domain.AdoptanteRequest
import com.patitas_web.domain.AdoptanteResponse
import com.patitas_web.infrastructure.DatabaseFactory.dbQuery
import com.patitas_web.infrastructure.tables.AdoptantesTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.time.format.DateTimeFormatter


class AdoptanteService {

    private fun todoptanteResponse(row: ResultRow): AdoptanteResponse = AdoptanteResponse(
        id =row [AdoptantesTable.id ],
        nombreCompleto = row[AdoptantesTable.nombreCompleto],
        telefono = row[AdoptantesTable.telefono],
        edad = row[AdoptantesTable.edad],
        ocupacion = row[AdoptantesTable.ocupacion],

    )
    suspend fun findAll(): List<Adoptante> = dbQuery {
        AdoptantesTable.selectAll().map(::toAdoptanteResponse)
    }
    suspend fun create(request: AdoptanteRequest): AdoptanteResponse {
        val result = dbQuery {
            val insertStatement = AdoptantesTable.insert { table ->
                table[nombreCompleto] = request.nombreCompleto
                table[telefono] = request.telefono
                table[edad] = request.edad
                table[ocupacion] = request.ocupacion
                table[ingresoMensual] = request.ingresoMensual
                table[horasDeTrabajo] = request.horasDeTrabajo
                table[tienePatio] = request.tienePatio
                table[ninosEnCasa] = request.ninosEnCasa
                table[tipoVivienda] = request.tipoVivienda
                table[convivientes] = request.convivientes
                table[mascotasAnteriores] = request.mascotasAnteriores
                table[aunConservaMascotas] = request.aunConservaMascotas
                table[responsabilidadesMascota] = request.responsabilidadesMascota
                table[opinionEsterilizacion] = request.opinionEsterilizacion
            }
            insertStatement.resultedValues?.singleOrNull()?.let(::toAdoptanteResponse)
        }
        return result ?: throw IllegalStateException("Error al guardar el adoptante en la base de datos.")
    }
}
